
public class CourseFile {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private String pathname;

    private CourseSerializer courseSerializer;

    private CourseDeserializer courseDeserializer;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public CourseFile(String pathname) throws NullPointerException {
        if (pathname == null) {
            throw new NullPointerException("\"pathname\" cannot be null");
        }
    }
    /* -------------------------------------------------Setters------------------------------------------------------ */

    /* -------------------------------------------------Getters------------------------------------------------------ */

    /* -------------------------------------------------Methods------------------------------------------------------ */

}
