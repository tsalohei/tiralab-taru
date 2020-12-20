# Testing documentation

## Automated testing

Testing was done with JUnit tests in most classes. Writing to and from file was done as an integration test to verify that the content of the original file would match the content of the decompressed file (this file is included in the project). Performance test was done with file 3 in the table below, and this file is included in the project.  Instructions for executing the tests can be found from the [README.md](https://github.com/tsalohei/tiralab-taru#tests) file.  

## Empirical testing

Testing results with 10 different files are presented in the table and graph below. All files were text files.

| Text                                        | Original file   (bytes) | Compressed file   (bytes) | Compression rate | Compression time (s) | Decompression   time |
|---------------------------------------------|-------------------------|---------------------------|------------------|----------------------|----------------------|
|[1. Rakas isänmaani](http://www.gutenberg.org/cache/epub/46655/pg46655.txt)                          | 193401                  | 99889                     | -48.35%          | 0.151839746          | 0.096862313          |
|[2. The Hobbit, full](https://www.pdfdrive.com/the-hobbit-e17592270.html)                         | 531147                  | 280572                    | -47.18%          | 0.242954207          | 0.122804458          |
|[3. Ulysses](http://www.gutenberg.org/files/4300/4300-0.txt)                                  | 1553256                 | 858265                    | -44.74%          | 0.417022638          | 0.27458819           |
|[4. The Hobbit, 1000 rows](https://www.pdfdrive.com/the-hobbit-e17592270.html)                    | 41949                   | 23270                     | -44.53%          | 0.111754581          | 0.061255163          |
|[5. Mrs Dalloway in Bond Street](http://www.gutenberg.org/cache/epub/63107/pg63107.txt)              | 37241                   | 21906                     | -41,18%          | 0.097649131          | 0.059749273          |
|[6. News article](https://yle.fi/uutiset/osasto/news/heavy_road_traffic_unlikely_in_finland_this_holiday_season/11702451)                             | 8721                    | 5460                      | -37.39%          | 0.07350391           | 0.038645061          |
|[7. The Hobbit, 100 rows](https://www.pdfdrive.com/the-hobbit-e17592270.html)                     | 926                     | 725                       | -21.71%          | 0.053799053          | 0.027874347          |
|[8. The Hobbit, 10 rows](https://www.pdfdrive.com/the-hobbit-e17592270.html)                      | 34                      | 91                        | 167.65%          | 0.05019651           | 0.025430724          |
| 9. File with 22 partly different characters | 23                      | 83                        | 260.87%          | 0.048155241          | 0.026119909          |
| 10. File with 22 characters (all different) | 26                      | 153                       | 488.46%          | 0.05068918           | 0.024832483          |

![Compression rates](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/images/testing_results.png)

Results show that compressing small files is inefficient; the file size actually increases. The worst compression rate was obtained with a small file where all characters were different (file 10). If the file was a real book (i.e. a long text), the compressed file was smaller than the original file (Files 1,2,3,5). Even a version of the Hobbit where 100 first rows were included was slightly compressed.

Compression time was under 0,5 seconds for even the largest file in the comparison (File 3, Ulysses with 1553256 bytes). Compression was slower for all files than decompression.  
