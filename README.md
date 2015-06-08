# PayoffWeatherTestLibs
(DRAFT)
PayoffWeatherTestsLib -

Supporting library for the PayoffWeatherTestsBVT test class.

It provides a rest-assured based web services DSL that is used to make calls to the Ultimate Weather Service.
Provides the setup for the service calls so they are not bound to tests (although doing it in this fashion sort of 
defeats the purpose of using a DSL type client versus a standard REST client).

ENUM provides a set of Types that describe a negative test condition against which to build our service request URL.

Library provides a set of precanned JSON parsing elements to access particular elements from response object strings.
It could be better tied to the service requests using rest-assured, but rest assured is much better suited for single 
request, parsing and comparisons than for more dynamic data.

this library can be built locally by using 

mvn clean install
or mvn install

In order for the resulting jar to be accessible from a CI system like Travis or Jenkins as a maven dependency.  It must be
deployed to the mvn-repo branch of this repo.  This is used to simulate an artifact repo such as Artifactory or maven-repo.

In order to build and deploy this artifact

mvn clean deploy.


