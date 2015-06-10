#Introduction
This toolbox provides Java components for building [CERIF](http://www.eurocris.org/Index.php?page=CERIFintroduction&t=1) applications. It has been tested with data covering the entire CERIF standard, using [MySQL](http://www.mysql.com), [PostgreSQL](http://www.postgresql.org/) and [SQL Server](http://www.microsoft.com/en-us/server-cloud/products/sql-server/).

This work is implemented by the Hellenic [National Documentation Centre](http://www.ekt.gr/en) in the frame of the project "[National Information System for Research & Technology/Social Networks-User Generated Content (NISRT)](http://www.epset.gr)" (Project ID 296115) within the Operational Programme "Digital Convergence" ([NSFR](http://www.digitalplan.gov.gr)), which is co-funded by [Greece](http://www.mfa.gr/en/) and the [European Union](http://europa.eu/) - [European Regional Development Fund](http://ec.europa.eu/regional_policy/en/funding/erdf/).

Besides having been incorporated in various systems and services of [NISRT](http://www.epset.gr), the libraries are utilised in other production applications like the [EuroRIs-Net+ Observatory](http://observatory.euroris-net.eu) and the [PAERIP Inventory of Research Infrastructures](http://inventory.paerip.org).

#Features

* CERIF Model
  * All CERIF entities are available as POJOs.
  * 100% compliant to the latest CERIF version.
* CERIF Services
  * [JPA](http://en.wikipedia.org/wiki/Java_Persistence_API) data repositories for all entities.
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

The recommended way to get started using CERIF Tools in your project is with a dependency management system. Specifically, CERIF Tools uses [Apache Maven](http://maven.apache.org/) for project management.

Include the appropriate dependency in pom.xml of your project, according to your needs.

For utilising the CERIF entities only:
```xml
<dependency>
  <groupId>gr.ekt</groupId>
  <artifactId>cerif-model</artifactId>
  <version>0.9.1</version>
</dependency>
```
For exporting CERIF-XML from an existing application:
```xml
<dependency>
  <groupId>gr.ekt</groupId>
  <artifactId>cerif-xml</artifactId>
  <version>0.9.1</version>
</dependency>
```
For building an application that is based on a relational database:
```xml
<dependency>
  <groupId>gr.ekt</groupId>
  <artifactId>cerif-services</artifactId>
  <version>0.9.1</version>
</dependency>
```
Lastly, for building a 3-tier application, e.g. a web application, that will have CERIF-XML capabilities, you should include both the *cerif-services* and the *cerif-xml* modules.

#Licensing information
The CERIF-Tools project is provided under the European Union Public Licence (EUPL), which is available in 22 official languages of the European Union, [here](http://joinup.ec.europa.eu/software/page/eupl/licence-eupl).

#Contact Us
[cerif-tools@ekt.gr](mailto:cerif-tools@ekt.gr)
