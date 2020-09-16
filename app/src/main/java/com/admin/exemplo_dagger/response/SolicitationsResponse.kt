package com.admin.exemplo_dagger.response


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class SolicitationsResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("lastPage")
    val lastPage: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("perPage")
    val perPage: Int,
    @SerializedName("total")
    val total: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(Data)!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    data class Data(
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("service_id")
        val serviceId: Int,
        @SerializedName("service_type")
        val serviceType: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("updated_at")
        val updatedAt: String,
        @SerializedName("user")
        var user: User,
        @SerializedName("user_id")
        val userId: Int,
        @SerializedName("visit_value")
        val visitValue: Double,
        @SerializedName("value")
        val value: Double
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readParcelable(User::class.java.classLoader)!!,
            parcel.readInt(),
            parcel.readDouble(),
            parcel.readDouble()
        )
        data class User(
            @SerializedName("accesses")
            val accesses: Int,
            @SerializedName("address")
            val address: String,
            @SerializedName("cep")
            val cep: String,
            @SerializedName("certified1")
            val certified1: String,
            @SerializedName("certified2")
            val certified2: String,
            @SerializedName("certified3")
            val certified3: String,
            @SerializedName("certified4")
            val certified4: String,
            @SerializedName("certified5")
            val certified5: String,
            @SerializedName("city")
            val city: String,
            @SerializedName("complement")
            val complement: String,
            @SerializedName("cpf")
            val cpf: String,
            @SerializedName("cpf_pic")
            val cpfPic: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("description")
            val description: String,
            @SerializedName("email")
            val email: String,
            @SerializedName("fullname")
            val fullname: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("last_access")
            val lastAccess: String,
            @SerializedName("latitude")
            val latitude: Double,
            @SerializedName("longitude")
            val longitude: Double,
            @SerializedName("payment_type")
            val paymentType: Int,
            @SerializedName("phone")
            val phone: String,
            @SerializedName("profile_pic")
            val profilePic: String,
            @SerializedName("proof_address")
            val proofAddress: String,
            @SerializedName("rg_back_pic")
            val rgBackPic: String,
            @SerializedName("rg_front_pic")
            val rgFrontPic: String,
            @SerializedName("service_type")
            val serviceType: String,
            @SerializedName("state")
            val state: String,
            @SerializedName("status")
            val status: String,
            @SerializedName("type")
            val type: String,
            @SerializedName("updated_at")
            val updatedAt: String?
        ) : Parcelable {
            constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readInt(),
                parcel.readString().toString(),
                parcel.readDouble(),
                parcel.readDouble(),
                parcel.readInt(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString()
            )

            override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(accesses)
                parcel.writeString(address)
                parcel.writeString(cep)
                parcel.writeString(certified1)
                parcel.writeString(certified2)
                parcel.writeString(certified3)
                parcel.writeString(certified4)
                parcel.writeString(certified5)
                parcel.writeString(city)
                parcel.writeString(complement)
                parcel.writeString(cpf)
                parcel.writeString(cpfPic)
                parcel.writeString(createdAt)
                parcel.writeString(description)
                parcel.writeString(email)
                parcel.writeString(fullname)
                parcel.writeInt(id)
                parcel.writeString(lastAccess)
                parcel.writeDouble(latitude)
                parcel.writeDouble(longitude)
                parcel.writeInt(paymentType)
                parcel.writeString(phone)
                parcel.writeString(profilePic)
                parcel.writeString(proofAddress)
                parcel.writeString(rgBackPic)
                parcel.writeString(rgFrontPic)
                parcel.writeString(serviceType)
                parcel.writeString(state)
                parcel.writeString(status)
                parcel.writeString(type)
                parcel.writeString(updatedAt)
            }

            override fun describeContents(): Int {
                return 0
            }

            companion object CREATOR : Parcelable.Creator<User> {
                override fun createFromParcel(parcel: Parcel): User {
                    return User(parcel)
                }

                override fun newArray(size: Int): Array<User?> {
                    return arrayOfNulls(size)
                }
            }
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(createdAt)
            parcel.writeString(date)
            parcel.writeString(description)
            parcel.writeInt(id)
            parcel.writeInt(serviceId)
            parcel.writeString(serviceType)
            parcel.writeString(status)
            parcel.writeString(type)
            parcel.writeString(updatedAt)
            parcel.writeParcelable(user, flags)
            parcel.writeInt(userId)
            parcel.writeDouble(visitValue)
            parcel.writeDouble(value)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Data> {
            override fun createFromParcel(parcel: Parcel): Data {
                return Data(parcel)
            }

            override fun newArray(size: Int): Array<Data?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(data)
        parcel.writeInt(lastPage)
        parcel.writeInt(page)
        parcel.writeInt(perPage)
        parcel.writeInt(total)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SolicitationsResponse> {
        override fun createFromParcel(parcel: Parcel): SolicitationsResponse {
            return SolicitationsResponse(parcel)
        }

        override fun newArray(size: Int): Array<SolicitationsResponse?> {
            return arrayOfNulls(size)
        }
    }
}