package com.miller.testapp_musicplayer.ui.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.miller.testapp_musicplayer.HorizontalAdapter
import com.miller.testapp_musicplayer.models.Video
import com.miller.testapp_musicplayer.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {

    private var _binding: FragmentMusicBinding? = null

    //    private var _viewModel: MusicViewModel by viewModels()
    private lateinit var _adapter: HorizontalAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val musicViewModel =
//            ViewModelProvider(this)[MusicViewModel::class.java]

        _binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureAdapter()
        _adapter.submitList(dummyData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configureAdapter() {
        _adapter = HorizontalAdapter()
        binding.recyclerviewMusicTen.apply {
            adapter = _adapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private val dummyData: List<Video> = listOf(
            Video(1, "a", "b"),
            Video(2, "a1", "b1"),
            Video(3, "a2", "b2"),

            )
}