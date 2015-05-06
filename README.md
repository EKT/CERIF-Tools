CERIF Components
================

Java components for building CERIF applications.

#Introduction
The cerif-jpa-persistence Java library enables programmatic access to [CERIF](http://www.eurocris.org/Index.php?page=CERIFintroduction&t=1) databases using the  [Java Persistence API](http://en.wikipedia.org/wiki/Java_Persistence_API).

The library provides easy-to-use functionality for persisting the various CERIF entities (base, result, linked etc.). It has been tested with data covering the entire CERIF standard, using both [MySQL](http://www.mysql.com) and [PostgreSQL](http://www.postgresql.org/).

Furthermore, a systematic way of extending the library for application-specific needs is provided. If interested, please have a look [here](https://code.google.com/p/cerif-jpa-persistence/wiki/CERIF_JPA_Overview_and_Architecture) at the library architecture and ways to extend it and at the [installations instructions](https://code.google.com/p/cerif-jpa-persistence/wiki/How_to_install_the_example_application) and [source code](https://code.google.com/p/cerif-jpa-persistence/source/browse/#svn%2Ftrunk%2Fexample_app) of a demo app - a detailed example of how the library can be used to build a complete 3-tier web application.

This work is implemented by the Hellenic [National Documentation Centre](http://www.ekt.gr/en) in the frame of the project "[National Information System for Research & Technology/Social Networks-User Generated Content (NISRT)](http://www.epset.gr)" (Project ID 296115) within the Operational Programme "Digital Convergence" ([NSFR](http://www.digitalplan.gov.gr)), which is co-funded by [Greece](http://www.mfa.gr/en/) and the [European Union](http://europa.eu/) - [European Regional Development Fund](http://ec.europa.eu/regional_policy/thefunds/regional/index_en.cfm).

Besides having been incorporated in various systems and services of [NISRT](http://www.epset.gr), the cerif-jpa-persistence library is utilised in other production applications like the [EuroRIs-Net+ Observatory](http://observatory.euroris-net.eu) and the [PAERIP Inventory of Research Infrastructures](http://inventory.paerip.org).


#Features

* CERIF Model
  * All 293 CERIF entities as POJOs.
  * 100% compliant to the latest CERIF version.
* CERIF Services
  * JPA data repositories for all entities.
  * Common persistence and selection services.
* CERIF XML
  * Full support of CERIF 1.6 XML Schema.
* CERIF REST *(not available in GitHub yet)*
  * RESTful services based on current EuroCRIS recommendation.
* CERIF OAI *(not available in GitHub yet)*
  * OAI-PMH implementation.

Here's a package diagram:

![Package diagram of the CERIF modules](https://cloud.githubusercontent.com/assets/5664469/7493597/058f11e2-f40b-11e4-81ea-40f4bc70ea7e.png)

#Quick Start

The recommended way to get started using CERIF Components in your project is with a dependency management system. Specifically, CERIF Components uses [Apache Maven](http://maven.apache.org/) for project management.

Include the appropriate dependency in pom.xml of your project, according to your needs.

For playing around with the CERIF entities only, you should only include the *cerif-model* module.
```xml
<dependency>
  <groupId>gr.ekt</groupId>
  <artifactId>cerif-model</artifactId>
  <version>0.9.1</version>
</dependency>
```
For exporting CERIF-XML from an existing non-CERIF application, you should only include the *cerif-xml* module.
```xml
<dependency>
  <groupId>gr.ekt</groupId>
  <artifactId>cerif-xml</artifactId>
  <version>0.9.1</version>
</dependency>
```
For building an application that is based on a relational database, you should only include the *cerif-service* module.
```xml
<dependency>
  <groupId>gr.ekt</groupId>
  <artifactId>cerif-service</artifactId>
  <version>0.9.1</version>
</dependency>
```
Lastly, for building a 3-tier application, e.g. a web application, that will have CERIF-XML capabilities, you should include both the *cerif-service* and the *cerif-xml* modules.

#Licensing information
European Union Public License, [more info](http://cerif-jpa-persistence.googlecode.com/files/LICENCE.txt).
