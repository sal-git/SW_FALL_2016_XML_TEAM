<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
<html>
<body>
<h1>
<b>
<xsl:value-of select="Course/Department"/>
</b>
</h1>
<h3>
<xsl:value-of select="Course/Prefix"/><xsl:text> </xsl:text>
<xsl:value-of select="Course/Number"/><xsl:text> - </xsl:text>
<xsl:value-of select="Course/Name"/>
</h3>
<xsl:value-of select="Course/Description"/>
<br/>
<br/>
<xsl:value-of select="Course/Credit-hours"/><xsl:text> Credit Hours</xsl:text>
<br/>
<xsl:value-of select="Course/Lecture-hours"/><xsl:text> Lecture Hours</xsl:text>
<br/>
<xsl:value-of select="Course/Lab-hours"/><xsl:text> Lab Hours</xsl:text>
<br/>
<br/>
<xsl:text>Schedule Types: </xsl:text><xsl:value-of select="Course/Schedule-type"/>
<br/>
<br/>
<xsl:text>Prerequisites: </xsl:text>
<xsl:value-of select="Course/Prerequisite"/>
<br/>
<xsl:text>Co-requisites: </xsl:text>
<xsl:value-of select="Course/Co-requisite"/>
<br/>
<xsl:text>Legacy Number: </xsl:text>
<xsl:value-of select="Course/Legacy-number"/>
<br/>
<xsl:text>Cross Listed: </xsl:text>
<xsl:value-of select="Course/Cross-listed"/>
<br/>
<br/>

<xsl:value-of select="Course/Restrictions"/>
<br/>
<xsl:for-each select="Course/Restrictions1/item1">
<li>
<xsl:value-of select="."/>
</li>
</xsl:for-each>
<br/>
<br/>
<xsl:value-of select="Course/Restrictions"/>
<br/>
<xsl:for-each select="Course/Restrictions2/item2">
<li>
<xsl:value-of select="."/>
</li>
</xsl:for-each>
<br/>
<br/>
<xsl:value-of select="Course/Course-attributes"/>
<br/>
</body>
</html>
</xsl:template>
</xsl:stylesheet>