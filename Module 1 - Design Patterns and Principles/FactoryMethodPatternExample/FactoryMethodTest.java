public class FactoryMethodTest {
    public static void main(String[] args) {
        // Instantiate different factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Create documents using the factories
        Document doc1 = wordFactory.createDocument();
        Document doc2 = pdfFactory.createDocument();
        Document doc3 = excelFactory.createDocument();

        // Open and close the generated documents
        System.out.println("--- Testing Factory Method Pattern ---");
        doc1.open();
        doc1.close();
        System.out.println();

        doc2.open();
        doc2.close();
        System.out.println();

        doc3.open();
        doc3.close();
    }
}
