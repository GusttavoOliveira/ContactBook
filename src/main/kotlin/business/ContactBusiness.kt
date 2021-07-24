package business

import entity.ContactEntity
import java.lang.Exception
import repository.ContactRepository

class ContactBusiness {

    fun getContactCountDescription(): String{
        val list = getList()

        return when{
            list.isEmpty() -> "0 contatos"
            list.size == 1 -> "1 contato"
            else -> "${list.size} contatos"
        }
    }

    fun save(name: String, phone: String){
        validate(name, phone)
        var contact = ContactEntity(name, phone)
        ContactRepository.save(contact)
    }

    fun delete(name: String, phone: String){
        validateDelete(name, phone)
        var contact = ContactEntity(name,phone)
        ContactRepository.delete(contact)
    }

    private fun validate(name: String, phone: String){
        if(name == ""){
            throw Exception("Nome é obrigatório")
        }
        if(phone == ""){
            throw Exception("Número é obrigatório")
        }
    }

    private fun validateDelete(name: String, phone: String){
        if(name == "" || phone == ""){
            throw Exception("É preciso selecionar um contato válido")
        }
    }

    fun getList(): List<ContactEntity>{
        return ContactRepository.getList()
    }


}