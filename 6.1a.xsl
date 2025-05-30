<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
	<xsl:for-each select="premios_nobel/premios/premio">
		<premio><xsl:value-of select="premiado"/>(<xsl:value-of select="@categoria"/>,<xsl:value-of select="año"/>)</premio>
	</xsl:for-each>
</xsl:template>
</xsl:stylesheet>
