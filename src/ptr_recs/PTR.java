package ptr_recs;

import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Scanner;

import net.ripe.commons.ip.Ipv4;
import net.ripe.commons.ip.Ipv4Range;
import sockslib.common.IPIterator;
import sockslib.common.IPRange;

public class PTR {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("result.txt");
		//String strRange = in.next();
		int k = 0 ,c = 0, i = 0;
		IPRange ipRange = IPRange.parse(args[0]);
		IPIterator iter = new IPIterator(ipRange);
		
		while (iter.hasNext()) {
			String ip = iter.next().toString();
			
			if (isValidPublicIp(ip)) {
				Inet4Address inetAddress = (Inet4Address) InetAddress.getByName(ip);
				String ptr = inetAddress.getCanonicalHostName();
				
				if (!ip.equals(ptr)) {
					fw.write(ptr + " --- PTR запись IP-адреса " + ip + "\n\n");
					k++;
				} else {
					System.out.println((ip + " нет PTR записи" + "\n"));
					k++;
				}
				
			} else {
				c++;
			}
			
			i++;
		}
		
		System.out.println(("Получено индивидуальных IP-адресов: " + i));
		System.out.println(("Всего незарезервированных IP-адресов: " + k));
		System.out.println(("Всего зарезервированных IP-адресов: " + c));
		
		fw.close();
		
	}
	
	private static boolean isValidPublicIp(String ip) {
	    return !(Ipv4Range.parseCidr("0.0.0.0/8").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("10.0.0.0/8").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("127.0.0.0/8").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("169.254.0.0/16").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("172.16.0.0/12").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("192.0.0.0/24").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("192.0.2.0/24").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("192.88.99.0/24").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("192.168.0.0/16").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("198.18.0.0/15").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("198.51.100.0/24").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("203.0.113.0/24").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("224.0.0.0/4").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("240.0.0.0/4").contains(Ipv4.parse(ip)) ||
	    		Ipv4Range.parseCidr("255.255.255.255/32").contains(Ipv4.parse(ip)));
	}

}
