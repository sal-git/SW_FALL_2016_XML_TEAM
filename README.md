# SW_FALL_2016_TEAM_2

Final packages that will be produced from this repostiory will be XMLMerge, XML2HTML, HTML2PDF and XSL style sheets. 

- XMLMerge
  XMLMerge is a class that will contain methods to combine XML files and a method to grab whole directores and merge every XML within. 
- HTML2PDF
  HTML2PDF is a class that will contain methods to convert HTML files to PDF format. 
- XML2HTML
  XML2HTML is a class that will contain methods to convert XML files to HTML format. 
  
# Example

For XMLMerge: 

``` 
mergeMultipleXMLDocs(ArrayList<String> list, String jointXmlRootNode, String outName, String path) 
```
Will merge multiple XML files and create one XML file with the desired root element tag, as well as provide the name of the file and optional path to save said file. 

```
mergeMultipleXMLDocsFromDataBase(String path, String jointXMLRootNodem, String outName, String path)
```
Will return an xml file from a specified directory and all sister directories. 


# Installation

Place Converter package within your project.

# Contributors
- Francisco
- Leo
- Lily
- Victor
- Stephen

# License

The MIT License


