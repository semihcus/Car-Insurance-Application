package com.example.insuranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;


public class InsurancePolicy extends AppCompatActivity {

    EditText ZipCode, CarMake, CarModel;
    TextView Policy1, Policy2, Policy3, Policy4;
    Button Submit, Single, Couple, Family, Commercial;
    Firebase Database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_policy);

        ZipCode = findViewById(R.id.ZipCodeEntry);
        Policy1 = findViewById(R.id.Policy1);
        Policy2 = findViewById(R.id.Policy2);
        Policy3 = findViewById(R.id.Policy3);
        Policy4 = findViewById(R.id.Policy4);
        Submit = findViewById(R.id.SubmitButton);
        CarMake = findViewById(R.id.CarMakeEntry);
        Single = findViewById(R.id.SinglePlan);
        Couple = findViewById(R.id.CouplePlan);
        Family = findViewById(R.id.FamilyPlan);
        Commercial = findViewById(R.id.CommercialPlan);
        CarModel = findViewById(R.id.CarPolicyModel);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Firebase.setAndroidContext(this);
        Database = new Firebase("https://insurance-app-67edc-default-rtdb.firebaseio.com/Policies/");

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Entry = Integer.parseInt(ZipCode.getText().toString());
                String Car = CarMake.getText().toString();
                String Model = CarModel.getText().toString();

                if (Entry == 11746 && Car.equals("Mercedes") && Model.equals("C240")) {
                    Policy1.setText(String.valueOf((99 * .10) + 150));
                    Policy2.setText(String.valueOf((99 * .15) + 150));
                    Policy3.setText(String.valueOf((99 * .20) + 150));
                    Policy4.setText(String.valueOf((99 * .25) + 150));
                    Single.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes C240 Single Policy, " + 159.9);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }

                    });

                    Couple.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes C240 Couple Policy, " + 164.85);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }

                    });

                    Family.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes C240 Family Policy, " + 169.8);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }
                    });

                    Commercial.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes C240 Family Policy, " + 174.75);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }
                    });
                }

                if (Entry == 11746 && Car.equals("Mercedes") && Model.equals("S550")) {
                    Policy1.setText(String.valueOf((99 * .10) + 170));
                    Policy2.setText(String.valueOf((99 * .15) + 170));
                    Policy3.setText(String.valueOf((99 * .20) + 170));
                    Policy4.setText(String.valueOf((99 * .25) + 170));
                    Single.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes S550 Single Policy, " + 179.9);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }

                    });

                    Couple.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes S550 Couple Policy, " + 184.85);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }

                    });

                    Family.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes S550 Family Policy, " + 189.8);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }
                    });

                    Commercial.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes S550 Family Policy, " + 194.75);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }
                    });
                }

                    if (Entry == 11747 && Car.equals("Toyota") && Model.equals("Corolla")) {
                        Policy1.setText(String.valueOf((85 * .10) + 100));
                        Policy2.setText(String.valueOf((85 * .15) + 100));
                        Policy3.setText(String.valueOf((85 * .20) + 100));
                        Policy4.setText(String.valueOf((85 * .25) + 100));
                        Single.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Toyota Corolla Single Policy, " + 108.5);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }

                        });

                        Couple.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Toyota Corolla Couple Policy, " + 112.75);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }

                        });

                        Family.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Toyota Corolla Family Policy, " + 117);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });

                        Commercial.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Toyota Corolla Commercial Policy, " + 121.25);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });
                    }

                if (Entry == 11747 && Car.equals("Toyota") && Model.equals("Camry")) {
                    Policy1.setText(String.valueOf((85 * .10) + 110));
                    Policy2.setText(String.valueOf((85 * .15) + 110));
                    Policy3.setText(String.valueOf((85 * .20) + 110));
                    Policy4.setText(String.valueOf((85 * .25) + 110));
                    Single.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Toyota Camry Single Policy, " + 118.5);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }

                    });

                    Couple.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Toyota Camry Couple Policy, " + 122.75);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }

                    });

                    Family.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Toyota Camry Family Policy, " + 127);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }
                    });

                    Commercial.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Toyota Camry Commercial Policy, " + 131.25);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }
                    });
                }

                    if (Entry == 11748 && Car.equals("Lamborghini") && Model.equals("Aventador")) {
                        Policy1.setText(String.valueOf((135 * .10) + 225));
                        Policy2.setText(String.valueOf((135 * .15) + 225));
                        Policy3.setText(String.valueOf((135 * .20) + 225));
                        Policy4.setText(String.valueOf((135 * .25) + 225));
                        Single.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Lamborghini Aventador Single Policy, " + 238.5);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }

                        });

                        Couple.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Lamborghini Aventador Couple Policy, " + 245.25);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }

                        });

                        Family.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + "Lamborghini Aventador Family Policy, " + 252);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });

                        Commercial.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Lamborghini Aventador Commercial Policy, " + 258.75);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });
                    }

                    if (Entry == 33995 && Car.equals("Mercedes") && Model.equals("C240")) {
                        Policy1.setText(String.valueOf((99 * .10) + 150));
                        Policy2.setText(String.valueOf((99 * .15) + 150));
                        Policy3.setText(String.valueOf((99 * .20) + 150));
                        Policy4.setText(String.valueOf((99 * .25) + 150));
                        Single.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Mercedes C240 Single Policy, " + 159.9);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }

                        });

                        Couple.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Mercedes C240 Couple Policy, " + 164.85);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }

                        });

                        Family.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Mercedes C240 Family Policy, " + 169.8);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });

                        Commercial.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Mercedes C240 Family Policy, " + 174.75);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });
                    }

                if (Entry == 33995 && Car.equals("Mercedes") && Model.equals("S550")) {
                    Policy1.setText(String.valueOf((99 * .10) + 170));
                    Policy2.setText(String.valueOf((99 * .15) + 170));
                    Policy3.setText(String.valueOf((99 * .20) + 170));
                    Policy4.setText(String.valueOf((99 * .25) + 170));
                    Single.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes S550 Single Policy, " + 179.9);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }

                    });

                    Couple.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes S550 Couple Policy, " + 184.85);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }

                    });

                    Family.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes S550 Family Policy, " + 189.8);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }
                    });

                    Commercial.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Mercedes S550 Family Policy, " + 194.75);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }
                    });
                }

                    if (Entry == 33995 && Car.equals("Toyota") && Model.equals("Corolla")) {
                        Policy1.setText(String.valueOf((85 * .10) + 100));
                        Policy2.setText(String.valueOf((85 * .15) + 100));
                        Policy3.setText(String.valueOf((85 * .20) + 100));
                        Policy4.setText(String.valueOf((85 * .25) + 100));
                        Single.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Toyota Corolla Single Policy, " + 108.5);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }

                        });

                        Couple.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Toyota Corolla Couple Policy, " + 112.75);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }

                        });

                        Family.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Toyota Corolla Family Policy, " + 117);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });

                        Commercial.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Toyota Corolla Commercial Policy, " + 121.25);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });
                    }

                if (Entry == 33995 && Car.equals("Toyota") && Model.equals("Camry")) {
                    Policy1.setText(String.valueOf((85 * .10) + 110));
                    Policy2.setText(String.valueOf((85 * .15) + 110));
                    Policy3.setText(String.valueOf((85 * .20) + 110));
                    Policy4.setText(String.valueOf((85 * .25) + 110));
                    Single.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Toyota Camry Single Policy, " + 118.5);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }

                    });

                    Couple.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Toyota Camry Couple Policy, " + 122.75);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }

                    });

                    Family.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Toyota Camry Family Policy, " + 127);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }
                    });

                    Commercial.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Email = user.getEmail();
                            Database.child("Policy").setValue(Email + ", Toyota Camry Commercial Policy, " + 131.25);
                            Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        }
                    });
                }

                    if (Entry == 33995 && Car.equals("Lamborghini") && Model.equals("Aventador")) {
                        Policy1.setText(String.valueOf((135 * .10) + 225));
                        Policy2.setText(String.valueOf((135 * .15) + 225));
                        Policy3.setText(String.valueOf((135 * .20) + 225));
                        Policy4.setText(String.valueOf((135 * .25) + 225));
                        Single.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Lamborghini Aventador Single Policy, " + 238.5);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }

                        });

                        Couple.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Lamborghini Aventador Couple Policy, " + 245.25);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }

                        });

                        Family.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Lamborghini Aventador Family Policy, " + 252);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });

                        Commercial.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Email = user.getEmail();
                                Database.child("Policy").setValue(Email + ", Lamborghini Aventador Commercial Policy, " + 258.75);
                                Toast.makeText(InsurancePolicy.this, "Policy Added Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                            }
                        });
                    }

            }
        });
    }
}
