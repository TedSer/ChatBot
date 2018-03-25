class Article {
    private String url;
    private String name;

    public Article (String url, String name) {
        this.url = url;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Article{" + "url = https://planetakino.ua" + url + ", name = " + name;

    }
}