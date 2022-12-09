JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  Main.java \
		  Affichage.java \
		  Trame_champ.java \
		  Trame_info.java \
			TCP.java \
			IpV4.java \
			Http.java \
			Champ.java \
			DataTypeException.java \
			EndOfFileException.java \
			WrongFileTypeException.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

run:
	java Main
