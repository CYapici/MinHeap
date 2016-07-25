MinHeap Java 
====
[![Project Status](http://opensource.box.com/badges/active.svg)](http://opensource.box.com/badges)
[![Project Status](http://opensource.box.com/badges/maintenance.svg)](http://opensource.box.com/badges)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/major/MinHeap Java-perl.svg)](http://isitmaintained.com/project/major/MinHeap Java-perl "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/major/MinHeap Java-perl.svg)](http://isitmaintained.com/project/major/MinHeap Java-perl "Percentage of issues still open")

MinHeap Java implementation with example usage frequency alternative to Java 8 collections filter     ...


 
**Question: How can i get most frequent top X item with java 8 **
 Map<String, Long> map = list.stream()
        .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
``` 
List<Map.Entry<String, Long>> result = map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(10)
        .collect(Collectors.toList());

 
``` 

Usage   
	--int selectTop=4;
	--Density density= new Density(selectTop);
	--foreach item values density.Read(item);
	- density.ExecuteResult()
```	 
  
MinHeap Java needs you
--
**MinHeap Java** needs contributors for documentation, code and feedbacks..
 
* Contribution guide is avalaible following [MinHeap Java contributing guide](https://github.com/major/MinHeap Java-perl/blob/master/CONTRIBUTING.md)
 
