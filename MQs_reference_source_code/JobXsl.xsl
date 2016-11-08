<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
version="1.0">
<xsl:output method="xml" indent="yes"/>
<xsl:template match="/">
<html>
<head><title>VaQPac In Action</title></head>
<body style="background:#D3D3D3">
<p>VaQPac In Action </p>
<p>Personal Information</p>
<center>
<h1 style="background-color: #d0e4fe">MK Quweider</h1>
<h2>123 Abc Drive</h2>
<h2>Toledo, Ohio</h2>
<img src="smt.png" alt="SMT College" style="width:100;height:100;"> </img>
 </center>

<p>Course</p>
<table align="center" border="1">
<tr>
<th>Department</th>
<th>Course</th> <!-- course prefix w/ number -->
<th>Name</th>
<th>Description</th>
<th>Credit-hours</th>
<th>Lecture-hours</th>
<th>Lab-hours</th>
<th>Level</th>
<th>Schedule-type</th>
</tr>
<xsl:for-each select="Experience/Job">
<tr>
<td><h3 style="background-color:red;color:blue"> <xsl:value-of select="employer"/></h3></td>
<td><xsl:value-of select="supervisor"/></td>
<td><xsl:value-of select="city"/></td>
<td><xsl:value-of select="state"/></td>
<td><xsl:value-of select="description"/></td>
<td><xsl:value-of select="years"/></td>
</tr>
</xsl:for-each>
</table>
</body></html>
</xsl:template>
</xsl:stylesheet>
