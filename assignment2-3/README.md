Download the following text file:

[Median.txt](https://d18ky98rnyall9.cloudfront.net/_6ec67df2804ff4b58ab21c12edcb21f8_Median.txt?Expires=1577059200&Signature=dpGptIIMv2ESkJ7r6KzuOPuZYJUXKQHRmYWMvCVuzVjL9LgYbjJ0uuS40MKQdmpUiuuLDUOFVan9YcknZYd3r9zjld1M6txl9OP6ft8DZV2-zH54077JBE9flarX6XvK2e3nbk5z5qPYs4prP3MmlTfMzH8hqCfYJJmX7l6mbF4_&Key-Pair-Id=APKAJLTNE6QMUY6HBC5A)

The goal of this problem is to implement the "Median Maintenance" algorithm (covered in the Week 3 lecture on heap applications). The text file contains a list of the integers from 1 to 10000 in unsorted order; you should treat this as a stream of numbers, arriving one by one. Letting x~i~ denote the i^th^ number of the file, the k^th^ median m~k~ is defined as the median of the numbers x~1~,…,x~k~,(So, if k is odd, then m~k~ is ((k+1)/2)th smallest number among x~1~,…,x~k~; if k is even, then m~k~ is the (k/2)(k/2)th smallest number among x~1~,…,x~k~.)

In the box below you should type the sum of these 10000 medians, modulo 10000 (i.e., only the last 4 digits). That is, you should compute (m1+m2+m3+⋯+m10000)mod10000.

OPTIONAL EXERCISE: Compare the performance achieved by heap-based and search-tree-based implementations of the algorithm.