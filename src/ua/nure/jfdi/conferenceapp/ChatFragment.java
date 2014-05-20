package ua.nure.jfdi.conferenceapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ChatFragment extends Fragment {

	/**
	 * The fragment argument representing the section number for this fragment.
	 */

	public static final String ARG_SECTION_NUMBER = "section_number";

	public ChatFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_chat,
				container, false);
		final EditText editText = (EditText) rootView
				.findViewById(R.id.messageEdit);
		final ViewGroup messagesContainer = (ViewGroup) rootView
				.findViewById(R.id.messagesContainer);
		final ScrollView scrollContainer = (ScrollView) rootView
				.findViewById(R.id.scrollContainer);
		Button sendMessageButton = (Button) rootView
				.findViewById(R.id.sendButton);
		sendMessageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showMessage(editText, null, null, false, rootView,
						messagesContainer, scrollContainer);
				showMessage(editText, "Иван Петров", "20.05.2014", true,
						rootView, messagesContainer, scrollContainer);
			}
		});

		return rootView;
	}

	void showMessage(EditText editText, String author, String date,
			boolean leftSide, View root, final ViewGroup messagesContainer,
			final ScrollView scrollContainer) {
		if (!leftSide) {
			final TextView textView = new TextView(root.getContext());
			textView.setTextColor(Color.BLACK);
			textView.setText(editText.getText().toString());
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			int bgRes = R.drawable.right_message_bg;
			params.gravity = Gravity.RIGHT;
			textView.setLayoutParams(params);
			textView.setBackgroundResource(bgRes);
			messagesContainer.addView(textView);
			scrollContainer.scrollTo(0, messagesContainer.getBottom());
			// editText.setText("");
		} else {
			final LinearLayout linearLayout = new LinearLayout(
					root.getContext());
			linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT));
			final ImageView imageView = new ImageView(linearLayout.getContext());
			LinearLayout.LayoutParams paramsIV = new LinearLayout.LayoutParams(
					30, 30);
			paramsIV.gravity = Gravity.BOTTOM;
			imageView.setLayoutParams(paramsIV);
			imageView.setImageResource(R.drawable.user_default);
			linearLayout.addView(imageView);
			final LinearLayout linearLayoutMessage = new LinearLayout(
					root.getContext());
			linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT));
			linearLayoutMessage.setOrientation(LinearLayout.VERTICAL);
			linearLayout.addView(linearLayoutMessage);
			final TextView textViewAuthor = new TextView(
					linearLayout.getContext());
			textViewAuthor.setTextColor(Color.BLACK);
			textViewAuthor.setText(author + ", " + date);
			LinearLayout.LayoutParams paramsTVA = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			textViewAuthor.setTextSize(8);
			textViewAuthor.setLayoutParams(paramsTVA);
			textViewAuthor.setPadding(7, 0, 0, 0);
			linearLayoutMessage.addView(textViewAuthor);
			final TextView textView = new TextView(linearLayout.getContext());
			textView.setTextColor(Color.BLACK);
			textView.setText(editText.getText().toString());
			textView.setBackgroundResource(R.drawable.left_message_bg);
			LinearLayout.LayoutParams paramsTV = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			textView.setLayoutParams(paramsTV);
			linearLayoutMessage.addView(textView);
			messagesContainer.addView(linearLayout);
			scrollContainer.scrollTo(0, messagesContainer.getBottom());
			editText.setText("");
		}
	}
}
