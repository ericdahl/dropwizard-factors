dropwizard-factors
==========================

Experimental project which sets up a web service with Dropwizard that returns factors.

#### Quick Start

```
$ git clone git@github.com:ericdahl/dropwizard-factors.git
$ cd dropwizard-factors
$ mvn clean install
$ java -jar target/dropwizard*jar server config.yml
```

and then make a request to

[http://localhost:8080/120](http://localhost:8080/120)

to return all of the factors of 120.