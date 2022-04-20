import com.egis.DocumentModel
import com.egis.kernel.Kernel
import com.egis.notification.EmailTemplateManager
import com.egis.utils.EmailDTO

DocumentModel doc = doc

EmailDTO dtoOld = Kernel.get(EmailTemplateManager.class).process("EmailChangeRequest",
        doc.metadata().all)
EmailDTO dtoNew = Kernel.get(EmailTemplateManager.class).process("EmailChangeRequest",
        doc.metadata().all)

doc.session.send(dtoOld.to(doc.metadata().get("new_email")).subject("Request to change email address"))
doc.session.send(dtoNew.to(doc.metadata().get("old_email")).subject("Request to change email address"))