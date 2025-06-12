class Traductor:
  def __init__(self, i_o="español", i_t="ingles"):
      self.Idioma_Original=i_o
      self.Idioma_Traducido=i_t
      self.Dic_Palabras={}
  def InsertarCadena(self, cadena):
      cadenas=[]
      cadena_buffer=""
      for i in range(0,len(cadena)):
          if (cadena[i]==" "):
              cadenas+=[cadena_buffer]
              cadena_buffer=""
          elif (i+1==len(cadena)):
              cadena_buffer+=cadena[i]
              cadenas+=[cadena_buffer]
          else:
              cadena_buffer+=cadena[i]
      for i in cadenas:
          if (not i in self.Dic_Palabras.keys()):
              acepcion=input("Dame la acepcion en "+self.Idioma_Traducido+" de "+i+": ")
              self.Dic_Palabras[i]=acepcion
          else:
              #puesto por claridad del codigo
              pass
  def __str__(self):
      returnable="Diccionario "+self.Idioma_Original+"-"+self.Idioma_Traducido
      returnable+="\n"
      for i in sorted(self.Dic_Palabras.keys()):
          returnable+=i+": "+self.Dic_Palabras[i]+"\n"
      return returnable
  def Traduccion_Normal(self,cadena):
      buffer=[""]
      returnable=[cadena]
      cadenas=[]
      cadena_buffer=""
      for i in range(0,len(cadena)):
          if (cadena[i]==" "):
              cadenas+=[cadena_buffer]
              cadena_buffer=""
          elif (i+1==len(cadena)):
              cadena_buffer+=cadena[i]
              cadenas+=[cadena_buffer]
          else:
              cadena_buffer+=cadena[i]
      for i in cadenas:
          if (i in self.Dic_Palabras.keys()):
              buffer[0]+=self.Dic_Palabras[i]+" "
          else:
              buffer[0]+="XXXX "
      return returnable+buffer
  def Traduccion_Inversa(self,cadena):
      buffer_traduccion=[]
      buffer=[""]
      returnable=[cadena]
      cadenas=[]
      cadena_buffer=""
      for i in range(0,len(cadena)):
          if (cadena[i]==" "):
              cadenas+=[cadena_buffer]
              cadena_buffer=""
          elif (i+1==len(cadena)):
              cadena_buffer+=cadena[i]
              cadenas+=[cadena_buffer]
          else:
              cadena_buffer+=cadena[i]
      for i in cadenas:
          for j in self.Dic_Palabras.keys():
              if self.Dic_Palabras[j]==i:
                  buffer_traduccion+=[j]
              else:
                  #por claridad del codigo
                  pass
          if (len(buffer_traduccion)==1):
              buffer[0]+=buffer_traduccion[0]+" "
          elif (len(buffer_traduccion)==0):
              buffer[0]+="XXXX "
          else:
              buffer[0]+=str(buffer_traduccion)
          buffer_traduccion=[]
      return returnable+buffer
              


traductor=Traductor()
print("0. Salir")
print("1. Introducir Palabras Al traductor")
print("2. Sacar Palabras traductor ordenadas alfabeticamente")
print("3. Traduccion normal")
print("4. Traduccion Inversa")
res=input()
while (int(res)!=0):
    if (int(res)==1):
        traductor.InsertarCadena(input("Palabras a introducir: "))
    elif (int(res)==2):
        print(traductor)
    elif (int(res)==3):
        resultado=traductor.Traduccion_Normal(input("Cadena a traducir: "))
        print(resultado[0])
        print(resultado[1])
    elif (int(res)==4):
        resultado=traductor.Traduccion_Inversa(input("Cadena a traducir: "))
        print(resultado[0])
        print(resultado[1])
    else:
        pass
    res=input()
