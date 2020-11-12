# Comparison of two lossless data compression algorithms

## Documentation

[Project description](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/project_description.md)

###  Weekly reports

[Week 1](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/weekly_reports/week1.md)

[Week 2](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/weekly_reports/week2.md)

[Week 3](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/weekly_reports/week3.md)

## Terminal commands

### Javadoc

Create a HTML-version of the JavaDoc with the following command:

	mvn javadoc:javadoc

The created JavaDoc can be found from directory target/site/apidocs.

### Tests

Tests can be run with the following command:

	mvn test

Create test coverage report:

	mvn test jacoco:report

View the created report by opening a file named index.html in directory /target/site/jacoco.

### Checkstyle

Run checks defined in file [checkstyle.xml](https://github.com/tsalohei/tiralab-taru/blob/main/tiralab-taru/checkstyle.xml) with this command:

	mvn jxr:jxr checkstyle:checkstyle

The Checkstyle report can be viewed by opening file /target/site/checkstyle.html with browser.
