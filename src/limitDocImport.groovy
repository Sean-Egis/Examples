import com.egis.DocumentModel
import com.egis.utils.ValidationException

//Scripted Node rule
//Filter:  document_type == 'VAT Certificates' || document_type == 'Banking Details'

DocumentModel doc = doc
def dupes = doc.session.query("Select * FROM 'Wurth/Application for Credit/Supporting Documents' WHERE formNo = '${doc.formNo}' AND document_type = '${doc.document_type}'")

if(dupes.size()>0){
    throw new ValidationException("You are only allowed to upload 1 Copy for ${doc.document_type}")
}