dropwizard-mersenne-primes
==========================

Experimental project which sets up a web service with Dropwizard that returns mersenne primes.

#### Quick Start

```
$ git clone git@github.com:ericdahl/dropwizard-mersenne-primes.git
$ cd dropwizard-mersenne-primes
$ mvn clean install
$ java -jar target/dropwizard*jar server config.yml
```

and then make a request to

[http://localhost:8080/3](http://localhost:8080/3)

to have it calculate whether ```2^3-1``` is prime, etc.