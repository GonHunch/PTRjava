# PTRjava
A simple java project that gets all ptr records from a given ip range
## How to install this program
This application is runnable from any IDE that supports java (Eclipse, IntelliJ, NetBeans e.t.c.).

You will need to import this program as a separate project to use it properly.

## How to use this program
In your IDE's console type a specific IP range with a "-" symbol with no spaces inbetween.

All the PTR records that are found will be put into a separate text file called "result.txt".

Reserved IPs (such as 127.0.0.1/8, 0.0.0.0/8 and others) will be skipped and unreserved IPs without a PTR record will be printed out in the IDE's console.

The program also prints out total number of IPs given, unreserved IPs given and reserved IPs given.

Down below is an example of the program's input and output on the IDE's console:

```
87.250.250.242-87.250.250.255
87.250.250.243 does not have a PTR record

87.250.250.244 does not have a PTR record

87.250.250.247 does not have a PTR record

87.250.250.250 does not have a PTR record

87.250.250.251 does not have a PTR record

87.250.250.252 does not have a PTR record

87.250.250.254 does not have a PTR record

87.250.250.255 does not have a PTR record

Individual IPs given: 14
Total number of unreserved IPs: 14
Total number of reserved IPs: 0
```

And result.txt would look like this after the execution:

```
ya.ru --- PTR record of 87.250.250.242

certificate-partners.mobile.yandex.net --- PTR record of 87.250.250.245

api.music.yandex.net --- PTR record of 87.250.250.246

thunderapi.weather.yandex.net --- PTR record of 87.250.250.248

mtproxy2d.metrika.yandex.net --- PTR record of 87.250.250.249

redmarket.stable.qloud-b.yandex.net --- PTR record of 87.250.250.253
```

## Libraries used
- [Sockslib](https://github.com/fengyouchao/sockslib) - used for IP iteration in IP range.

- [Commons IP math](https://github.com/jgonian/commons-ip-math) - used to check whether an IP is reserved or not.
