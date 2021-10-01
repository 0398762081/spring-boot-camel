package vn.molu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "routing")
public class Rout {

	@Id 
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    @Column(name = "copydate")
    private Date copyDate;
	
	@Column(name = "fileName")
    private String fileName;

    @Column(name = "sourcefolder")
    private String sourceFolder;
    
    @Column(name = "destinationfolder")
    private String destinationFolder;

    public Date getCopyDate() {
		return copyDate;
	}

	public void setCopyDate(Date copyDate) {
		this.copyDate = copyDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSourceFolder() {
		return sourceFolder;
	}

	public void setSourceFolder(String sourceFolder) {
		this.sourceFolder = sourceFolder;
	}

	public String getDestinationFolder() {
		return destinationFolder;
	}

	public void setDestinationFolder(String destinationFolder) {
		this.destinationFolder = destinationFolder;
	}
}
