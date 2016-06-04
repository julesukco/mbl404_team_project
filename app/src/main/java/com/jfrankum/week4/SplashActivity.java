package com.jfrankum.week4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashActivity.this, Main.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();

        // Insert a couple of rows of test data
        createDummyData();

    }

    private void createDummyData() {
        // Dummy code to insert a few clinics to get us started
        ClinicDBHelper clinicDBHelper = new ClinicDBHelper(getApplicationContext());
        Clinic clinic;

        try {
            clinic = new Clinic(1, "Hino Ronald H MD", "98-151 Pali Momi St, #142", "Aiea", "HI", "96701", "Director", "Dr. Honolulu", "(808) 487-2477", "http://www.Aiea.com", "Open", "21.381948", "-157.940255");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(2, "Farmer Joesph F Md", "1225 Breckenridge Dr", "Little Rock", "AR", "72205", "Owner", "Dr. Pulaski", "(501) 225-2594", "http://www.Little Rock.com", "Open", "34.764945", "-92.387883");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(3, "Najjar Fadi Md", "1155 W Linda Ave", "Hermiston", "OR", "97838", "Lead Physician", "Dr. Umatilla", "(541) 289-1122", "http://www.Hermiston.com", "Closed", "45.846102", "-119.310282");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(4, "Kittson Memorial Upper Level Nursing Home", "1010 S Birch Ave", "Hallock", "MN", "56728", "Head Doctor", "Dr. Kittson", "(218) 843-2525", "http://www.Hallock.com", "Open", "48.767605", "-96.940454");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(5, "Thompson Robert B Md", "100 N Eagle Creek Dr", "Lexington", "KY", "40509", "Physician", "Dr. Fayette", "(859) 258-4000", "http://www.lexingtonclinic.com", "Closed", "37.998369", "-84.442505");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(6, "Hubert Roy DVM", "3000 W 95th St", "Evergreen Park", "IL", "60805", "Director", "Dr. Cook", "(708) 422-9007", "http://www.EvergreenPark.com", "Open", "41.720814", "-87.697033");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(7, "Brascho Donn MD", "2505 US-431", "Boaz", "AL", "35957", "Owner", "Dr. Marshall", "(256) 840-3688", "http://www.Boaz.com", "Open", "34.221356", "-86.159364");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(8, "Dakota Chiropractic Clinic", "320 Dakota Ave", "Wahpeton", "ND", "58075", "Lead Physician", "Dr. Richland", "(701) 642-5600", "http://www.Wahpeton.com", "Closed", "46.263921", "-96.604367");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(9, "Culpeper Memorial Hospital Inc - Maternal Child Health", "501 Sunset Ln", "Culpeper", "VA", "22701", "Head Doctor", "Dr. Culpeper", "(540) 829-4113", "http://www.Culpeper.com", "Open", "38.455709", "-78.012003");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(10, "Delong Donald DVM", "2585 Cruse Rd", "Lawrenceville", "GA", "30044", "Physician", "Dr. Gwinnett", "(770) 277-3220", "http://www.Lawrenceville.com", "Closed", "33.941073", "-84.079594");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(11, "Crestwood Manor", "2600 Stockton Blvd", "Sacramento", "CA", "95817", "Director", "Dr. Sacramento", "(916) 452-1431", "http://www.Sacramento.com", "Open", "38.55178", "-121.45573");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(13, "Pike Medical Clinic Inc", "905 Highway 161", "Bowling Green", "MO", "63334", "Owner", "Dr. Pike", "(573) 324-2241", "http://www.BowlingGreen.com", "Open", "39.332443", "-91.194994");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(14, "Berkshire Health Systems - Hillcrest Campus of BMC", "165 Tor Ct", "Pittsfield", "MA", "1201", "Lead Physician", "Dr. Berkshire", "(413) 443-4761", "http://www.Pittsfield.com", "Closed", "42.456179", "-73.281334");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(15, "University Of Maryland Hosp", "S Greene St", "Baltimore", "MD", "21201", "Head Doctor", "Dr. Baltimore City", "(410) 547-2620", "http://www.Baltimore.com", "Open", "39.288275", "-76.623624");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(16, "Chan Yeung", "205 N King St", "Seguin", "TX", "78155", "Physician", "Dr. Guadalupe", "(830) 379-0305", "http://www.Seguin.com", "Closed", "29.570047", "-97.949851");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(17, "Ierulli Victor DO", "401 W Mohawk Dr", "Tomahawk", "WI", "54487", "Director", "Dr. Lincoln", "(715) 453-7200", "http://www.Tomahawk.com", "Open", "45.488962", "-89.73322");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(18, "Demore H L DVM - RES", "Mount Airy Clarkesvi", "Mt Airy", "GA", "30563", "Owner", "Dr. Habersham", "(706) 778-6035", "http://www.MtAiry.com", "Open", "34.515337", "-83.501642");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(19, "Evolution Benefits Incorporated", "22 Waterville Rd", "Avon", "CT", "6001", "Lead Physician", "Dr. Hartford", "(860) 678-5560", "http://www.evolutionbenefits.com", "Closed", "41.80363", "-72.818483");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(20, "Cedars-Sinai Medical Care Foundation - Administration", "250 N Robertson Blvd", "Beverly Hills", "CA", "90211", "Head Doctor", "Dr. Los Angeles", "(310) 385-3200", "http://www.cedars-sinai.edu", "Open", "34.069649", "-118.383761");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(21, "Newton Regional Hospital", "208 S Main St", "Newton", "MS", "39345", "Physician", "Dr. Newton", "(601) 683-2031", "http://www.newtonregionalhospital.com", "Closed", "32.320127", "-89.163469");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(22, "Lansing Clinic", "50 S 4th St", "Lansing", "IA", "52151", "Director", "Dr. Allamakee", "(563) 538-4874", "http://www.Lansing.com", "Open", "43.362225", "-91.218749");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(23, "Grundman David Md", "800 E Locust St", "Olney", "IL", "62450", "Owner", "Dr. Richland", "(618) 395-1944", "http://www.Olney.com", "Open", "38.735021", "-88.076926");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(24, "Loveland Dialysis", "2940 Ginnala Dr", "Loveland", "CO", "80538", "Lead Physician", "Dr. Larimer", "(970) 663-9155", "http://www.Loveland.com", "Closed", "40.423212", "-105.071054");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(25, "Apache Junction Urgent Care LLC", "2080 W Southern Ave", "Apache Junction", "AZ", "85120", "Head Doctor", "Dr. Pinal", "(480) 985-0172", "http://www.nextcare.com", "Open", "33.393368", "-111.567583");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(26, "Peterson Rehabilitation Hospital & Geriatric Center", "Homestead Ave", "Wheeling", "WV", "26003", "Physician", "Dr. Ohio", "(304) 234-0552", "http://www.Wheeling.com", "Closed", "40.080725", "-80.694489");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(27, "Ashford Rowell S II PHYS SURG", "1526 5th Ave S", "Birmingham", "AL", "35233", "Director", "Dr. Jefferson", "(205) 521-6200", "http://www.Birmingham.com", "Open", "33.505031", "-86.808016");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(28, "Planned Parenthood - Pill Orders", "24 Pennacook St", "Manchester", "NH", "3104", "Owner", "Dr. Hillsborough", "(603) 622-0333", "http://www.Manchester.com", "Open", "43.001382", "-71.463227");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(29, "Fresenius", "141 Gateway Dr", "Brandon", "MS", "39042", "Lead Physician", "Dr. Rankin", "(601) 591-0053", "http://www.Brandon.com", "Closed", "32.285335", "-90.021146");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(30, "Seidel Saundra L APN BL", "82 W Sunbridge Dr", "Fayetteville", "AR", "72703", "Head Doctor", "Dr. Washington", "(479) 575-9000", "http://www.Fayetteville.com", "Open", "36.098002", "-94.158709");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }
        try {
            clinic = new Clinic(31, "Sameshima James MD", "265 W Ina Rd", "Tucson", "AZ", "85704", "Physician", "Dr. Pima", "(520) 694-8100", "http://www.Tucson.com", "Closed", "32.336776", "-110.974044");
            clinicDBHelper.insertClinic(clinic);
        } catch (Exception e) {
            // ignore dup record insert
        }

    }
}