package quaere.deepak.skilldevelopment.tutorials;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import quaere.deepak.skilldevelopment.R;

/**
 * Created by intex on 3/26/2016.
 */
public class Tutorials extends Activity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListheader;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorials_layout);
        expandableListView = (ExpandableListView) findViewById(R.id.tutorials_expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListheader = new ArrayList<String>(expandableListDetail.keySet());

        expandableListAdapter = new ExpandableListAdapters(this, expandableListheader, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        findViewById(R.id.tutorials_backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
               /* Toast.makeText(getApplicationContext(),
                        expandableListheader.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();*/
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        expandableListheader.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();*/

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String header = expandableListDetail.get(expandableListheader.get(groupPosition)).get(childPosition);
                topicDetail(header);
/*
                Toast.makeText(
                        getApplicationContext(),
                        expandableListheader.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListheader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                )
                        .show();*/
                return false;
            }
        });
    }

    private void topicDetail(String header) {
        String title = header;
        Intent i = new Intent(Tutorials.this, TopicDetails.class);

        if (title.equals("Introduction")) {
            String detail = getResources().getString(R.string.Introuduction);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Advantages of C")) {
            String detail = getResources().getString(R.string.advantage_of_c);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Function Basics")) {
            String detail = getResources().getString(R.string.function_basics);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Defination and Declaration")) {
            String detail = getResources().getString(R.string.function_definition_declaration);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Standard Header files")) {
            String detail = getResources().getString(R.string.standard_header_files);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Block ans Scopes")) {
            String detail = getResources().getString(R.string.Introuduction);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Structures")) {
            String detail = getResources().getString(R.string.structures);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Unions")) {
            String detail = getResources().getString(R.string.unions);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Preprocessor Directives")) {
            String detail = getResources().getString(R.string.proprocessor_dirctives);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Variables")) {
            String detail = getResources().getString(R.string.variables);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Operators")) {
            String detail = getResources().getString(R.string.operators);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Arrays")) {
            String detail = getResources().getString(R.string.arrays);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Pointer")) {
            String detail = getResources().getString(R.string.pointers);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("String")) {
            String detail = getResources().getString(R.string.strings);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Conditional branching - if")) {
            String detail = getResources().getString(R.string.branching_if);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Conditional Selection - switch")) {
            String detail = getResources().getString(R.string.selection_switch);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Loops - while,for")) {
            String detail = getResources().getString(R.string.loops);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("File Operation and functions")) {
            String detail = getResources().getString(R.string.file_operation_and_function);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Variable Storage Classes")) {
            String detail = getResources().getString(R.string.storage_classes);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Definition vs Declaration")) {
            String detail = getResources().getString(R.string.definition_vs_declaration);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Structure Of Program")) {
            String detail = getResources().getString(R.string.structure_of_program);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Break and Continue")) {
            String detail = getResources().getString(R.string.break_continue);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Formatted IO-printf,scanf")) {
            String detail = getResources().getString(R.string.formatted_io);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Character IO-getchar,putchar")) {
            String detail = getResources().getString(R.string.character_io);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        } else if (title.equals("Block and Scopes")) {
            String detail = getResources().getString(R.string.blocks_scope);
            i.putExtra("title", title);
            i.putExtra("detail", detail);
            startActivity(i);

        }
    }
}
