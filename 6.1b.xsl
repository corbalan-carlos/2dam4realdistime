<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
	<table border="1">
		<tr>
			<th>Categoria y año</th>
			<th>Ganador</th>
		</tr>
		<xsl:for-each select="premios_nobel/premios/premio">
			<tr>
				<td><p><xsl:value-of select="@categoria"/> <xsl:value-of select="año"/></p></td>
				<td><xsl:value-of select="premiado"/></td>
					
			</tr>
		</xsl:for-each>
	</table>
</html>
</xsl:template>
</xsl:stylesheet>
