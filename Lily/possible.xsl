<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
	<html>
	<body>
		<h1><b><xsl:value-of select="Course/Department"/></b></h1>
		
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
		
		<xsl:text>Schedule Type: </xsl:text><xsl:value-of select="Course/Schedule-type"/>
		<br/>
		<br/>
		
		<xsl:text>Prerequisites: </xsl:text>
		<br/>
			<xsl:for-each select="Course/Prerequisite/item">
			<li>
			<xsl:value-of select="."/>
			</li>
			</xsl:for-each>
		<br/>
		
		<xsl:text>Co-requisites: </xsl:text>
		<br/>
			<xsl:for-each select="Course/Co-requisite/item">
			<li>
			<xsl:value-of select="."/>
			</li>
			</xsl:for-each>
		<br/>
		
		<xsl:text>Legacy Number: </xsl:text>
			<xsl:value-of select="Course/Legacy-number"/>
		<br/>
		<xsl:text>Cross Listed: </xsl:text>
			<xsl:value-of select="Course/Cross-listed"/>
		<br/>
		<br/>
		
		<xsl:text>Rescrticion Programs: </xsl:text>
		<br/>
			<xsl:for-each select="Course/Restrictions1/item">
			<li>
			<xsl:value-of select="."/>
			</li>
			</xsl:for-each>
		<br/>
		
		<xsl:value-of select="Course/Restrictions_Levels"/>
		<br/>
			<xsl:for-each select="Course/Restrictions/item">
			<li>
			<xsl:value-of select="."/>
			</li>
			</xsl:for-each>
		<br/>
		<br/>
		<xsl:value-of select="Course/Attributes"/>
		<br/>
			<xsl:for-each select="Course/Course-attributes/item">
			<li>
			<xsl:value-of select="."/>
			</li>
			</xsl:for-each>
		<br/>
	</body>
	</html>
</xsl:template>
</xsl:stylesheet>
