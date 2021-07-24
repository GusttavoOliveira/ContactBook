package business

import java.lang.Exception

class ContactBusiness {

    fun save(name: String, phone: String){
        validate(name, phone)
    }

    fun delete(name: String, phone: String){
        validateDelete(name, phone)
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


}