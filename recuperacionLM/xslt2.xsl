<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
        <table>
            <tr>
            <th> nombre</th>
            <th> fecha de nac</th>
            </tr>
        </table>
            <xsl:for-each select="//profesor[@nacimiento>'1975']">
                    <p>
                        <xsl:select select="."></xsl:select>
                    </p>
            </xsl:for-each>

        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>