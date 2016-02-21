package com.myandroid.mygorod.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myandroid.mygorod.R;
import com.myandroid.mygorod.entities.Element;

public class PlantDetailFragment extends Fragment{
    private Element element;

    public PlantDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView textViewName = (TextView)rootView.findViewById(R.id.textViewNamePlant);
        TextView textViewDescription = (TextView)rootView.findViewById(R.id.textViewDescription);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
        final Intent intent = getActivity().getIntent();
        element = (Element) intent.getSerializableExtra(getResources().getString(R.string.info_key));
        if (element != null) {
            textViewName.setText(element.getName());
            textViewDescription.setText(element.getDescription());
            imageView.setImageBitmap(element.getImage());
        } else {
            textViewName.setText("Морква");
            textViewDescription.setText("Як виростити моркву.\n\n" +
                    "Вирощування моркви у відкритому ґрунті передбачає проріджування сходів при занадто густому їх зростанні, постійне розпушування і очищення ділянки від бур'яну, який може стати причиною деяких хвороб, регулярний полив моркви. Перше проріджування сходів здійснюють після того, як у них розвинуться перші справжні листочки – відстань між морквинами повинна бути 2-3 см. Коли з'явиться друга пара листків, сіянці проривають вдруге, збільшуючи відстань між ними вдвічі. Якщо ви при посадці використовували паперову стрічку або кульки, то проріджувати сіянці вам не доведеться. Прополювання ділянки проводиться в ті ж терміни, що і проріджування, і краще цим займатися після поливання ділянки, коли ґрунт вологий.\n" +
                    "\n" +
                    "Зберігання моркви після збору врожаю\n" +
                    "Полив моркви.\n\n" +
                    "Якщо ви хочете виростити великі, соковиті, солодкі коренеплоди, потрібно знати, як поливати моркву. Недостатній полив – причина появи у рослини гіркуватого присмаку і млявості. Полив моркви – найважливіший пункт догляду за рослиною протягом усіх стадій розвитку. Глибина зволоження ділянки має відповідати розмірам коренеплодів, тобто земля повинна просочуватися водою під час поливання не менше, аніж на 30 см. Нестача зволоження провокує появу на коренеплодах бічних корінців, що ростуть у пошуках джерел вологи, від чого страждає не тільки зовнішній вигляд плоду, а й його смакові якості – м'якоть стає грубою і жорсткою. Надмірне зволоження є причиною розтріскування плодів, вони покриваються дрібною паростю, посилюється ріст бадилля. Зазвичай моркву поливають раз на тиждень приблизно в такому об'ємі:\n" +
                    "\n" +
                    "– після посіву ділянку поливають із розрахунку 3 л на 1 м²;\n" +
                    "– після другого проріджування сіянців кількість води на одиницю площі збільшується до 10 л;\n" +
                    "– коли починається ріст коренеплодів, а це відбувається після наростання листя, витрата води має бути в межах 20 л на м²;\n" +
                    "– за півтора-два місяці до збирання моркви переходять на режим поливу один раз у півтора-два тижні кількістю води близько 10 л на одиницю площі, а за два-три тижні до збору врожаю полив припиняють взагалі.\n" +
                    "Помаранчево-фіолетова морква\n" +
                    "Підживлення моркви.\n\n" +
                    "Протягом вегетаційного періоду удобрення моркви здійснюють двічі – вперше через місяць після появи сходів, вдруге через два місяці. Чим удобрювати моркву? Вносять добрива в рідкому вигляді і приблизно в такому складі: дві склянки деревної золи, столова ложка нітрофоски, 20 г калійної селітри і по 15 г суперфосфату і сечовини на відро води. Внесення добрив здійснюється після попереднього поливання моркви.\n" +
                    "\n" +
                    "Обробка моркви.\n\n" +
                    "Чим хворіє морква і як обробити моркву від хвороб і шкідників, ви прочитаєте в наступному розділі.");
        }
        return rootView;
    }
}
