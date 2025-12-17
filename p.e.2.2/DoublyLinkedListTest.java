public class DoublyLinkedListTest {

    private DoublyLinkedList list;

    public static void main(String[] args) {
        DoublyLinkedListTest test = new DoublyLinkedListTest();

        System.out.println("=== EJECUCIÓN DE PRUEBAS DOUBLY LINKED LIST ===\n");

        test.runTest("TC-DLL-001 Insertar en lista vacía", test::insertIntoEmptyList);
        test.runTest("TC-DLL-002 Eliminar en lista vacía", test::deleteFromEmptyList);
        test.runTest("TC-DLL-003 Eliminar único elemento", test::deleteOnlyElement);
        test.runTest("TC-DLL-004 Eliminar head", test::deleteHead);
        test.runTest("TC-DLL-005 Eliminar tail", test::deleteTail);
        test.runTest("TC-DLL-006 Eliminar elemento intermedio", test::deleteMiddleElement);
        test.runTest("TC-DLL-007 Eliminar elemento inexistente", test::deleteNonExistingElement);
        test.runTest("TC-DLL-008 Invertir lista vacía", test::reverseEmptyList);
        test.runTest("TC-DLL-009 Invertir lista con un elemento", test::reverseSingleElementList);
        test.runTest("TC-DLL-010 Invertir lista con varios elementos", test::reverseMultipleElements);

        System.out.println("\n✓ TODAS LAS PRUEBAS SE EJECUTARON CORRECTAMENTE");
    }

    private void runTest(String testName, Runnable testMethod) {
        setUp();
        try {
            testMethod.run();
            System.out.println("✔ " + testName + " — OK");
        } catch (AssertionError e) {
            System.out.println("✘ " + testName + " — FALLÓ");
            throw e;
        }
    }

    void setUp() {
        list = new DoublyLinkedList();
    }

    void insertIntoEmptyList() {
        list.InsertAtEnd(10);
        assert !list.isEmpty() : "La lista no debe estar vacía";
    }

    void deleteFromEmptyList() {
        assert !list.deleteByValue(10) : "Eliminar en lista vacía debe retornar false";
    }

    void deleteOnlyElement() {
        list.InsertAtEnd(10);
        assert list.deleteByValue(10) : "Debe eliminar el elemento";
        assert list.isEmpty() : "La lista debe quedar vacía";
    }

    void deleteHead() {
        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        assert list.deleteByValue(10) : "Debe eliminar el head";
    }

    void deleteTail() {
        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        assert list.deleteByValue(20) : "Debe eliminar el tail";
    }

    void deleteMiddleElement() {
        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        list.InsertAtEnd(30);
        assert list.deleteByValue(20) : "Debe eliminar elemento intermedio";
    }

    void deleteNonExistingElement() {
        list.InsertAtEnd(10);
        assert !list.deleteByValue(99) : "Debe retornar false";
    }

    void reverseEmptyList() {
        list.reverse();
        assert list.isEmpty() : "La lista debe seguir vacía";
    }

    void reverseSingleElementList() {
        list.InsertAtEnd(10);
        list.reverse();
        assert !list.isEmpty() : "La lista no debe quedar vacía";
    }

    void reverseMultipleElements() {
        list.InsertAtEnd(1);
        list.InsertAtEnd(2);
        list.InsertAtEnd(3);
        list.reverse();
        assert !list.isEmpty() : "La lista invertida no debe estar vacía";
    }
}
