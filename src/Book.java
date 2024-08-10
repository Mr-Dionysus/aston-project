public class Book {
    private String author;
    private String name;
    private int pages;

    public Book(BookBuilder bookBuilder) {
        author = bookBuilder.author;
        name = bookBuilder.name;
        pages = bookBuilder.pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "\nAuthor: " + this.author + "\nName:   " + this.name + "\nPages:  " + this.pages;
    }

    public static class BookBuilder {
        private String author;
        private String name;
        private int pages = 0;

        public BookBuilder(String author, String name, int pages) {
            this.author = author;
            this.name = name;
            this.pages = pages;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
