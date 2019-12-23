package com.github.myapplication.LazyFragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.github.myapplication.R
import kotlinx.android.synthetic.main.fragment_my.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MyFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MyFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MyFragment : LazyFragment() {

    private var param1: String? = null
    private var textView:TextView? = null

    override fun getLayoutRes(): Int {
        return R.layout.fragment_my
    }

    override fun initView(view: View) {
        textView = view.findViewById(R.id.text)
        textView?.text = param1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i(param1,"onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        Log.i(param1,"onResume")
    }


    override fun onFragmentLoad() {
        super.onFragmentLoad()
        Log.i(param1,"网络加载")
    }

    override fun onFragmentLoadStop() {
        super.onFragmentLoadStop()
        Log.i(param1,"网络停止")
    }

    override fun onPause() {
        super.onPause()
        Log.i(param1,"onPause")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(param1,"onDestroyView")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            MyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
