package normal;
/**
 * Created by liker on 09/07/2015 0009.
 * Group iTailor.hunters.neu.edu.cn
 */
public class PfReportStyle implements java.io.Serializable  , Cloneable {

    // Fields
    private static final long serialVersionUID = 1L;

    private Long id;

    private byte[] reportByte;

    // Constructors

    /** default constructor */
    public PfReportStyle() {
    }

    /** minimal constructor */
    public PfReportStyle(Long id) {
        this.id = id;
    }

    /** full constructor */
    public PfReportStyle(Long id, byte[] reportByte) {
        this.id = id;
        this.reportByte = reportByte;
    }

    // Property accessors

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getReportByte() {
        return this.reportByte;
    }

    public void setReportByte(byte[] reportByte) {
        this.reportByte = reportByte;
    }
}

