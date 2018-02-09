    private Bitmap myOriginalBmp;
    private ImageView myOriginalView;
    private ImageView myNewImageView;

    private String[] myImageNames;
    private ArrayList<Bitmap> myImageBmps;

    private void initSpinner (){
        Spinner spinner = (Spinner) findViewById(R.id.imageNames);
        myImageNames = 
                getResources().getStringArray(R.array.imageNames);
        ArrayAdapter adapter = new ArrayAdapter<String> (this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                myImageNames);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener
                 (new MySpinnerListener());
    }



    private void initImageArray (){
        myImageBmps = new ArrayList<Bitmap>();
        TypedArray imageIds =
            getResources().obtainTypedArray(R.array.imageIdArray);

        for (int i=0; i<myImageNames.length; i++) {
            int id = imageIds.getResourceId(i, 0);
            if (id == 0)
                id = imageIds.getResourceId(0, 0);
            Bitmap bmp =
                 BitmapFactory.decodeResource(getResources(), id);
            myImageBmps.add(bmp);
        }
    }


    private class MySpinnerListener implements
                                     OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parentView,
                                   View selectedItemView,
                                   int position,
                                   long id){
            myOriginalView.setImageBitmap
                    (myImageBmps.get(position));
            BitmapDrawable originalDrawableBmp =
                    (BitmapDrawable) myOriginalView.getDrawable();
            myOriginalBmp = originalDrawableBmp.getBitmap();
        }

        public void onNothingSelected(AdapterView<?> parentView){

        }
    }


