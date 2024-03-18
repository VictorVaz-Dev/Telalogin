package com.example.tela_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.tela_login.ui.theme.TelaloginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "loginScreen") {
                composable("loginScreen") {
                    Login_Project(navController = navController)
                }
                composable("homeScreen") {
                    HomeScreen(navController = navController)
                }
            }
        }
    }
}


@Composable
fun Login_Project(navController: NavController) {
    Button(
        onClick = { navController.popBackStack() },
        modifier = Modifier.align(Alignment.CenterHorizontally)
    ) {
        Text(text = "Voltar para o Login")
    }
}
@Preview
fun Login_Project() {

    var login by remember {
        mutableStateOf("")
    }

    var senha by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1000.dp)
                    .background(colorResource(id = R.color.white))
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Card(
                        modifier = Modifier
                            //.height(300.dp)
                            .fillMaxWidth()
                            .offset(y = 100.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        shape = RoundedCornerShape(32.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(
                                vertical = 16.dp,
                                horizontal = 32.dp
                            )
                        ) {
                            Text(
                                text = "Faça seu login",
                                modifier = Modifier.fillMaxWidth(),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.green_project),
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(32.dp))
                            Image(
                                painterResource(id = R.drawable.resume),
                                contentDescription = "Imagem de formulario",
                                modifier = Modifier
                                    .size(90.dp)
                                    .align(Alignment.CenterHorizontally),


                                )

                            Text(
                                text = "Login",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = colorResource(id = R.color.green_project)
                            )
                            OutlinedTextField(
                                value = login,
                                onValueChange = {
                                    login = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(text = "Seu login de acesso")
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.green_project),
                                    focusedBorderColor = colorResource(id = R.color.green_project)
                                ),
                                shape = RoundedCornerShape(16.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Senha",
                                modifier = Modifier.padding(bottom = 8.dp),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                color = colorResource(id = R.color.green_project)
                            )
                            OutlinedTextField(
                                value = senha,
                                onValueChange = {
                                    senha = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "Sua senha"
                                    )
                                },
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = colorResource(id = R.color.green_project),
                                    focusedBorderColor = colorResource(id = R.color.green_project)
                                ),
                                shape = RoundedCornerShape(16.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "Esqueceu sua senha?",
                                modifier = Modifier.fillMaxWidth(),
                                color = colorResource(id = R.color.green_project),
                                textAlign = TextAlign.End
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(
                                        id = R.color.green_project
                                    )
                                )
                            ) {
                                Text(
                                    text = "Entrar",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }