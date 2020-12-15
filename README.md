# Huffman lossless data compression algorithm

## Documentation

[Project description](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/project_description.md)

[Implementation document](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/implementation.md)

[Testing document](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/testing.md)

[User instructions](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/user_instructions.md)

###  Weekly reports

[Week 1](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/weekly_reports/week1.md)

[Week 2](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/weekly_reports/week2.md)

[Week 3](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/weekly_reports/week3.md)

[Week 4](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/weekly_reports/week4.md)

[Week 5](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/weekly_reports/week5.md)

[Week 6](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/weekly_reports/week6.md)

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

View the created report by opening a file named index.html in directory target/site/jacoco.

### Checkstyle

Run checks defined in file [checkstyle.xml](https://github.com/tsalohei/tiralab-taru/blob/main/tiralab-taru/checkstyle.xml) with this command:

	mvn jxr:jxr checkstyle:checkstyle

The Checkstyle report can be viewed by opening file target/site/checkstyle.html with browser.
