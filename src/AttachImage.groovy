import com.egis.DocumentModel
import com.egis.Session
import com.egis.kernel.Kernel
import com.egis.notification.EmailTemplateManager
import com.egis.utils.EmailDTO
import com.egis.utils.FileObject

DocumentModel doc = doc
Session s = Kernel.get(Session.class)

imageLogo = s.getDocument('System/images/SantamRe_logo.png')

EmailDTO dto = Kernel.get(EmailTemplateManager.class).process("Email-Template-Name", doc.metadata().all)
dto.attachContentPart(new FileObject(imageLogo.content().read(), imageLogo.filename))