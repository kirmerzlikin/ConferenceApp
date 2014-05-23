package ua.nure.jfdi.conferenceapp.view;

import ua.nure.jfdi.conferenceapp.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class SigninDialog extends DialogFragment {

	DialogListener mListener;

	StringBuilder name = new StringBuilder("");

	public String getName() {
		return name.toString();
	}
	
	public void setName(String s){
		name.append(s);
	}

	public interface DialogListener {
		public void onDialogPositiveClick(DialogFragment dialog);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		// Get the layout inflater
		LayoutInflater inflater = getActivity().getLayoutInflater();

		// Inflate and set the layout for the dialog
		// Pass null as the parent view because its going in the dialog layout
		final View v = inflater.inflate(R.layout.dialog_signin, null);
		builder.setView(v);
		// Add action buttons

		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {
				String s1 = ((EditText) v.findViewById(R.id.name)).getText()
						.toString();
				String s2 = ((EditText) v.findViewById(R.id.surname)).getText()
						.toString();
				SigninDialog.this.setName(s1 + " " + s2);
				mListener.onDialogPositiveClick(SigninDialog.this);
			}
		});

		return builder.create();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// Verify that the host activity implements the callback interface
		try {
			// Instantiate the NoticeDialogListener so we can send events to the
			// host
			mListener = (DialogListener) activity;
		} catch (ClassCastException e) {
			// The activity doesn't implement the interface, throw exception
			throw new ClassCastException(activity.toString()
					+ " must implement NoticeDialogListener");
		}
	}

}
