
void main() {
    MiLista miLista = new MiLista();
    System.out.println(miLista.toString());

    miLista.insertHead(0);

//    System.out.println(miLista.toString());
    miLista.insertHead("Juan");
    miLista.insertHead(true);

//    System.out.println(miLista.toString());

    miLista.insertTail("Angela");

    System.out.println(miLista.toString());
    System.out.println(miLista.getSize());

    miLista.clear();

    System.out.println(miLista.toString());

    miLista.insertTail(5);
    System.out.println(miLista.toString());
    miLista.getSize();
    System.out.println(miLista.getSize());
}
