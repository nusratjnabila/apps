package com.example.peakperformers.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.peakperformers.R;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.text.Html;

import com.example.peakperformers.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Find the TextView in your layout by its ID
        TextView aboutTextView = root.findViewById(R.id.idTextViewAbout);

        // Set the text you want to display
        String aboutText = "<b><h1>About Us:<h4>\"Wherever You Roam, We're Your Road Home.\"</h4></h1><h4> Your Trusted Roadside Companion</h4></b>" +
                "RoadAssist is a dedicated team of professionals committed to providing top-tier roadside assistance services. With years of experience under our belt, we have honed our skills and refined our operations to offer you the best support when you need it most." +
                "<h5>Our Mission:</h5>" +
                " Our mission is simple yet vital: to get you back on the road safely and swiftly. We understand that a roadside emergency can be stressful and inconvenient, which is why we've made it our goal to alleviate those burdens. Our services are designed to provide peace of mind and ensure you receive the help you need promptly."+
                "What Sets Us Apart:\n" +
                "\n" +
                "<h6>24/7 Availability:</h6> Emergencies don't keep office hours, and neither do we. You can count on us to be there for you, day or night, rain or shine.\n" +
                "\n" +
                "<h6>Fast Response Time:</h6> When you call RoadAssist, you won't be left waiting by the side of the road for hours. Our skilled technicians are dispatched promptly to your location.\n" +
                "\n" +
                "<h6>Professionalism:</h6> Our team is comprised of certified and experienced professionals who approach every situation with professionalism and a commitment to your safety.\n" +
                "\n" +
                "<h6>Comprehensive Services:</h6> From flat tires and dead batteries to lockouts and fuel delivery, we offer a wide range of services to handle all kinds of roadside challenges.\n" +
                "\n" +
                "<h6>Cutting-Edge Technology:</h6> We leverage the latest technology to streamline our operations, ensuring a seamless experience for our customers.\n" +
                "\n" +
                "<h6>Customer-Centric Approach:</h6> Your satisfaction is our priority. We listen to your needs and tailor our services to meet your specific requirements.\n"+
                "<h5>Our Commitment to You:</h5>" +
                "\n" +
                "At RoadAssist, we don't just provide assistance, we offer peace of mind. When you choose us as your roadside companion, you can trust that you're in capable hands. We're here to turn your unexpected roadside setback into a minor inconvenience, getting you back on your journey without a hitch.\n" +
                "\n" +
                "Whether you're a daily commuter, a road trip enthusiast, or a commercial driver, RoadAssist is here to support you on every mile of your journey. Join the countless satisfied customers who have made us their trusted road assistance partner.\n" +
                "\n" +
                "Don't let a roadside emergency disrupt your plans or cause undue stress. Choose RoadAssist, and let us be your beacon of hope on the open road. We're here to help when you need it most – because your journey matters to us.\n" +
                "\n"+
                "";

        // Use HTML formatting to display bold headers
        aboutTextView.setText(Html.fromHtml(aboutText));



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
