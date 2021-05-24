/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase receptor
:*
:*  Archivo     : SmsReceptor.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 20/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que permite recibir un mensaje SMS a otro
:*                telefono celular
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u4smsreceptorapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceptor extends BroadcastReceiver {

    @Override
    public void onReceive ( Context context, Intent intent ) {

        SmsMessage smsMensajes [] = Telephony.Sms.Intents.getMessagesFromIntent ( intent );

        if ( smsMensajes != null ) {
            SmsMessage sms = smsMensajes [ 0 ];
            String telef = sms.getOriginatingAddress ();
            String texto = sms.getMessageBody ();

            Calendar c = Calendar.getInstance ();
            c.setTimeInMillis ( sms.getTimestampMillis () );
            String fechaHora = c.getTime().toString();

            Toast.makeText ( context,
                    "SMS: (" +fechaHora + ")\n" +telef + "\n" +texto, Toast.LENGTH_LONG )
                    .show ();
        }
    }
}
