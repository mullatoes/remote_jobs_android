import android.os.Parcelable
import java.time.LocalDateTime
import kotlinx.parcelize.Parcelize

@Parcelize
data class Job(
    val jobId: String = "", // default value provided
    val title: String = "", // default value provided
    val type: String = "", // default value provided
    val description: String = "", // default value provided
    val company: String = "", // default value provided
    val companyLogo: String = "", // default value provided
    val timePosted: LocalDateTime? = null, // default value provided
    val skills: ArrayList<String>? = null, // default value provided
    val payScaleMin: Int? = null, // default value provided
    val payScaleMax: Int? = null, // default value provided
    var views: Int? = null, // default value provided
    val applications: Int? = null, // default value provided
    val noOfEmployeesLowBound: Int? = null, // default value provided
    val noOfEmployeesHighBound: Int? = null, // default value provided
    val companyType: String = "", // default value provided
    val companyCity: String = "", // default value provided
    val companyCountry: String = "", // default value provided
    val responsibilities: ArrayList<String>? = null, // default value provided
    val niceToHaveSkills: ArrayList<String>? = null, // default value provided
    val experienceLevel: String = "", // default value provided
    val duration: String = "", // default value provided
    val isBookmarked: Boolean = false, // default value provided
    val submitUrl: String = "", // default value provided
    val availability: String = "", // default value provided
) : Parcelable

//More fields to be added
//stack
//availability
