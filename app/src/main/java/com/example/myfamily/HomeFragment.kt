package com.example.myfamily

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemMember = listOf<MemberModel>(
            MemberModel("Saurav Kumar","89%","123M"),
            MemberModel("Ashutosh Dubey","54%","143M"),
            MemberModel("Shubham Kumar","87%","432M"),
            MemberModel("Himanshu Kumar","7%","765M"),
            MemberModel("Raushan Kumar", "89%","54M")
        )
        val adapter = MemberAdapter(itemMember)
        val recycler = requireView().findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter


        val contactAdapter = InviteAdapter(fetchContact())
        val contactRecycler = requireView().findViewById<RecyclerView>(R.id.recycler_invite)
        contactRecycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        contactRecycler.adapter =contactAdapter
    }

    private fun fetchContact(): List<ContactModel> {

        val listContact :ArrayList<ContactModel> = ArrayList()
        val cr = requireActivity().contentResolver
        val cursor = cr.query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null)
        if(cursor!= null && cursor.count>0){

            while(cursor.moveToNext()){
                val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val hasPhoneNumber = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))


                if(hasPhoneNumber > 0){

                    val pCur = cr.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID+ "=?",
                        arrayOf(id),
                        ""
                    )
                    if(pCur != null && pCur.count>0){
                        while (pCur!= null && pCur.moveToNext() )
                        {
                            val phoneNum = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            listContact.add(    ContactModel(name,phoneNum))
                        }
                        pCur.close()
                    }
                }
            }
            cursor.close()
        }
        return listContact
    }


    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()

    }
}