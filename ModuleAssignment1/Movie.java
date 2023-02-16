public class Movie {

    private String title;
    private String releaseDate;
    private int runtime;

    public Movie(String title, String releaseDate, int runtime){
        this.title = title;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public int getRuntime() {
        return runtime;
    }
    public void setRuntime(int runtime) {
         this.runtime = runtime;
    }



    @Override
    public String toString(){
        return (title + " (" + releaseDate + ") " + runtime + " minutes");
    }
    

 

}
