public class Library {

    // Linear Search by title - Time Complexity: O(N)
    public static Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search by title - Time Complexity: O(log N) (Requires sorted array)
    public static Book binarySearchByTitle(Book[] sortedBooks, String targetTitle) {
        int low = 0;
        int high = sortedBooks.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = sortedBooks[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return sortedBooks[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
