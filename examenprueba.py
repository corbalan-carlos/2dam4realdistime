import random
class Examen:
  modulo=""
  preguntas = {}
  def insertarPregunta(self, pregunta, respuesta, puntuacion, tema="python"):
    puntuacionCorregida=puntuacion
    if (puntuacion < 0):
      puntuacionCorregida=1
    elif (puntuacion > 10):
      puntuacionCorregida=10
    if (not tema in self.preguntas):
      self.preguntas.update({tema:[(pregunta,respuesta,puntuacionCorregida)]})
    else :
      self.preguntas[tema].append((pregunta,respuesta,puntuacionCorregida))
  def __str__(self):
    returnable=""
    for x in self.preguntas:
      returnable=returnable+"Tema:"+x+"\n\n"
      for y in self.preguntas[x]:
        returnable=returnable+"Pregunta:"+y[0]+"\n"
        returnable=returnable+"Respuesta:" +y[1]+"\n"
        returnable=returnable+"Puntacion:"+str(y[2])+"\n"
    return returnable 
  def GenerarExamen(self,tema,n):
    if (not tema in self.preguntas):
      print("Tema no encontrado, cancelando funcion...")
      return
    if (len(self.preguntas[tema])<n):
      print("No hay suficientes preguntas, cancelando funcion...")
      return
    source=self.preguntas[tema]
    i=0
    mask=0
    while (i<n):
      mb=random.randint(0,len(source)-1)
      if ((1<<mb)&mask!=1):
        mask=mask+(1<<mb)
        i+=1 
    print(mask)
    preguntasSeleccionadas=[]
    i=0
    counter=0
    while (i<n):
      if ((mask>>counter)&0x1):
         preguntasSeleccionadas.append(source[counter])
         i+=1
      counter+=1
    puntuacionMaxima=0
    puntuacion=0
    for j in preguntasSeleccionadas:
      puntuacionMaxima+=j[2]
      print(j[0])
      result=input()
      if (result==j[1]):
        puntuacion+=j[2]
    print("Total Preguntas:"+str(n))
    print("Puntuacion Maxima Posible:"+str(puntuacionMaxima))
    print("Puntuacion Obtenida:"+str(puntuacion))
