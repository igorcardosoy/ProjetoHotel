SRC = src/Main.java src/view/*.java src/model/*.java ./src/model/enums/*.java ./src/model/acomodacoes/*.java ./src/model/itensCosumo/*.java ./src/model/pessoas/*.java

NAME = Hotel

CC = javac

RUN = java


all:
	$(CC) -d $(NAME) $(SRC)

run:
	$(RUN) -cp $(NAME) Main
