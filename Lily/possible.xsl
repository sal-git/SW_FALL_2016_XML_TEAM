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
		<xsl:value-of select="Course/Credit-hours"/>
		<br/>
		<xsl:value-of select="Course/Lecture-hours"/>
		<br/>
		<xsl:value-of select="Course/Lab-hours"/>
		<br/>
<br/>
		<xsl:text>Levels: </xsl:text><xsl:value-of select="Course/Level"/>
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
		
		<xsl:text>Restriction Programs: </xsl:text>
		<br/>
			<xsl:for-each select="Course/Restrictions1/item">
			<li>
			<xsl:value-of select="."/>
			</li>
			</xsl:for-each>
		<br/>
		
		<xsl:text>Restriction Levels: </xsl:text>
		<br/>
			<xsl:for-each select="Course/Restrictions2/item">
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

